package com.iudigital.controller;

import com.iudigital.dao.FuncionarioDao;
import com.iudigital.domain.Funcionario;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {

    private FuncionarioDao funcionarioDao;

    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }

    public void crear(Funcionario func) throws SQLException {
        funcionarioDao.crear(func);
    }

    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        return funcionarioDao.obtenerFuncionarios();
    }

    public Funcionario obtenerFuncionario(Integer idFuncionario) throws SQLException {
        return funcionarioDao.obtenerFuncionario(idFuncionario);
    }

    public void actualizarFuncionario(Integer idFuncionario, Funcionario func) throws SQLException {
        funcionarioDao.actualizarFuncionario(idFuncionario, func);
    }

    public void eliminarFuncionario(Integer idFuncionario) throws SQLException {
        funcionarioDao.elimminarFuncionario(idFuncionario);
    }
}
