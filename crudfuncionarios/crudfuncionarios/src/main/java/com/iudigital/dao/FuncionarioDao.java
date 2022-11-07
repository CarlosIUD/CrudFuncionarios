package com.iudigital.dao;

import com.iudigital.domain.Funcionario;
import com.iudigital.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    private static final String GET_FUNCIONARIOS = "select * from funcionario";

    private static final String CREATE_FUNCIONARIO = "insert into funcionario"
            + "(id_funcionario, tipo_id, nombres, apellidos, estado_civil," +
            "sexo, direccion, telefono, fecha_nacimiento )"
             + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionario where id_funcionario = ? ";

    private static final String UPDATE_FUNCIONARIO = "update funcionario set tipo_id = ?, nombres = ?, apellidos = ?, " +
            "sexo = ?, direccion = ?, telefono = ?, fechaNacimiento = ?,  where id_funcionario = ?";

    private static final String DELETE_FUNCIONARIO = "delete from funcionario where id_funcionario = ?";


    public void crear(Funcionario func) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = null;
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIO);
            preparedStatement.setInt(1, func.getIdFuncionario());
            preparedStatement.setString(2, func.getTipoId());
            preparedStatement.setString(3, func.getNombres());
            preparedStatement.setString(4, func.getApellidos());
            preparedStatement.setString(5, func.getSexo());
            preparedStatement.setString(6, func.getDireccion());
            preparedStatement.setInt(7, func.getTelefono());
            preparedStatement.setDate(8, func.getFechaNacimiento());
            preparedStatement.setString(9, func.getEstadoCivil());
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


    }

    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcs = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               Funcionario func = new Funcionario();

               func.setIdFuncionario(resultSet.getInt("idFuncionario"));
               func.setTipoId(resultSet.getString("tipoId"));
               func.setNombres(resultSet.getString("nombres"));
               func.setApellidos(resultSet.getString("apellidos"));
               func.setSexo(resultSet.getString("sexo"));
               func.setDireccion(resultSet.getString("direccion"));
               func.setTelefono(resultSet.getInt("telefono"));
               func.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
               func.setEstadoCivil(resultSet.getString("estadoCivil"));

               funcs.add(func);

            }

            return funcs;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }

    }

    public Funcionario obtenerFuncionario(Integer idFuncionario) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        Funcionario func = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, idFuncionario);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                func = new Funcionario();

                func.setIdFuncionario(resultSet.getInt("idFuncionario"));
                func.setTipoId(resultSet.getString("tipoId"));
                func.setNombres(resultSet.getString("nombres"));
                func.setApellidos(resultSet.getString("apellidos"));
                func.setSexo(resultSet.getString("sexo"));
                func.setDireccion(resultSet.getString("direccion"));
                func.setTelefono(resultSet.getInt("telefono"));
                func.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
                func.setEstadoCivil(resultSet.getString("estadoCivil"));
            }
            return func;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }

    public void actualizarFuncionario(Integer idFuncionaro, Funcionario func) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_FUNCIONARIO);

            preparedStatement.setInt(1, func.getIdFuncionario());
            preparedStatement.setString(2, func.getTipoId());
            preparedStatement.setString(3, func.getNombres());
            preparedStatement.setString(4, func.getApellidos());
            preparedStatement.setString(5, func.getSexo());
            preparedStatement.setString(6, func.getDireccion());
            preparedStatement.setInt(7, func.getTelefono());
            preparedStatement.setDate(8, func.getFechaNacimiento());
            preparedStatement.setString(9, func.getEstadoCivil());


        }finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public void elimminarFuncionario(Integer idFuncionario) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, idFuncionario
            );
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }

        }
    }
}
