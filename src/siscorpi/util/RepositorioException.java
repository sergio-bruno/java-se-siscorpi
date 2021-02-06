/*
 * RepositorioException.java
 *
 * Created on 23 de Agosto de 2005, 22:59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */
package siscorpi.util;
/**
 *
 * @author sergio
 */
public class RepositorioException extends Exception {
    private Exception exception;

    public RepositorioException(Exception exception) {
        super("Exceção encapsulada");
        this.exception = exception;
    }
    public String getMessage() {
        return exception.getMessage();
    }
    public void printStackTrace() {
        exception.printStackTrace();
    }
}