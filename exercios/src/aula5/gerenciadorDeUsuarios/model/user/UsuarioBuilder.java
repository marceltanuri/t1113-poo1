package aula5.strategy.model.user;

import aula5.strategy.exception.SenhaInvalidaException;
import aula5.strategy.model.password.validador.SenhaValidator;
import aula5.strategy.model.password.validador.factory.SenhaValidatorFactory;
import aula5.strategy.model.user.validador.UserValidator;
import aula5.strategy.model.user.validador.exception.InvalidUserException;
import aula5.strategy.model.user.validador.factory.UserValidatorFactory;
import aula5.strategy.util.PropertiesUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioBuilder {

    protected UsuarioBuilder(){

    }

    private final Usuario usuario = new Usuario();

    public UsuarioBuilder comSenha(String senha){
        this.usuario.senhaAtual = senha;
        return this;
    }

    public UsuarioBuilder comDataNascimento(String dataNascimento) throws InvalidUserException{
        String regex = PropertiesUtil.getInstance().getProperty("usuario.validator.dataNascimento.regexp");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dataNascimento);
        if(!matcher.matches()){
            throw new InvalidUserException("Formato de data de nascimento deve ser DD/MM/AAAA");
        }
        this.usuario.dataNascimento = dataNascimento;
        return this;
    }

    public Usuario build() throws InvalidUserException, SenhaInvalidaException {
        List<UserValidator> validadoresDeUsuario = UserValidatorFactory.getInstance().getImplementations();
        List<SenhaValidator> validadoresDeSenha = SenhaValidatorFactory.getInstance().getImplementations();

        for (UserValidator validadorDeUsuario : validadoresDeUsuario) {
            validadorDeUsuario.validar(this.usuario);
        }
        for (SenhaValidator validadorDeSenha : validadoresDeSenha) {
            validadorDeSenha.validar(this.usuario, this.usuario.senhaAtual);
        }

        return this.usuario;
    }

}
