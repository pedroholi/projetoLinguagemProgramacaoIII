/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsuarioDAO;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author Pedro
 */
public class UsuarioController {
    UsuarioDAO dao;

    public UsuarioController() {
        dao = new UsuarioDAO();
    }

    public void cadastrar(Usuario user) {
        dao.cadastrar(user);
    }

    public void deletar(Usuario user) {
        dao.deletar(user);
    }

    public Usuario pesquisar(String user) {
        return dao.pesquisar(user);
    }
   
    public Usuario pesquisar(int codigo) {
        return dao.pesquisar(codigo);
    }
    
    public void alterar(Usuario user) {
        dao.alterar(user);
    }

    public ArrayList<Usuario> selecionarUsuarios() {
        return dao.selecionarUsuarios();
    }
    
    public ArrayList<Usuario> pesquisarUsuarios(String nome){
       return dao.pesquisarUsuarios(nome);
    }
}
