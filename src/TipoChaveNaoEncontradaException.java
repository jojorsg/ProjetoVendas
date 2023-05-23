package main.java;

public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = -2037581219418007396L;

    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
