package com.iudigital.test;

import com.iudigital.controller.FuncionarioController;
import com.iudigital.domain.Funcionario;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void crear(FuncionarioController funcionarioController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite la el documento del funcionario");
            Integer documento = sc.nextInt();
            System.out.println("-----------");

            System.out.println("Digite el tipo de documento del funcionario (cédula, pasaporte, cédula de extranjería)");
            String tipoId = sc.nextLine();
            System.out.println("-----------");

            System.out.println("Digite el nombre del funcionario");
            String nombre = sc.nextLine();
            System.out.println("-----------");

            System.out.println("Digite los apellidos del funcionario");
            String apellidos = sc.nextLine();
            System.out.println("-----------");

            System.out.println("Digite el sexo del funcionario (M o F): ");
            String sexo = sc.nextLine();
            System.out.println("-----------");

            System.out.println("Digite la dirección del funcionario ");
            String direccion = sc.nextLine();
            System.out.println("-----------");

            System.out.println("Digite el teléfono del funcionario");
            Integer telefono = sc.nextInt();
            System.out.println("-----------");

            System.out.println("Digite la fecha de nacimiento del funcionario en formato aaaa/m/d ");
            Date fechaNacimiento = Date.valueOf(sc.nextLine());
            System.out.println("-----------");

            //Seteamos los valores ingresados por consola a partir de una instancia de Funcionario

            Funcionario func = new Funcionario();

            func.setIdFuncionario(documento);
            func.setTipoId(tipoId);
            func.setNombres(nombre);
            func.setApellidos(apellidos);
            func.setSexo(sexo);
            func.setDireccion(direccion);
            func.setTelefono(telefono);
            func.setFechaNacimiento(fechaNacimiento);

            funcionarioController.crear(func);
            System.out.println("El carro se ha creado con éxito");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        crear(funcionarioController);
    }
}