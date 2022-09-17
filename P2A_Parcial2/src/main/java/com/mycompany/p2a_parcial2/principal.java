/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.p2a_parcial2;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Windows 10
 */
public class principal {
 public static void ej1(int id){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/db_vendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","40%lkd2E");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT *,(Enero+Febrero+Marzo+Abril+Mayo+Junio) as Total FROM db_vendedores.tb_vendedores where niv = "+id;
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
            while(resultado.next()){
                System.out.println("niv = "+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Enero = "+resultado.getInt(3));
                System.out.println("Febrero = "+resultado.getInt(4));
                System.out.println("Marzo = "+resultado.getInt(5));
                System.out.println("Abril = "+resultado.getInt(6));
                System.out.println("Mayo = "+resultado.getInt(7));
                System.out.println("Junio = "+resultado.getInt(8));
                System.out.println("Total = "+resultado.getInt(9));
            }
        } catch (SQLException ex) {
            System.out.println("Hubo problem = "+ex.getMessage());
            
        }
}
 public static void ej2(){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/db_vendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","40%lkd2E");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT * FROM db_vendedores.tb_vendedores";
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
            while(resultado.next()){
                System.out.println("NIV = "+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("Enero = "+resultado.getInt(3));
                System.out.println("Febrero = "+resultado.getInt(4));
                System.out.println("Marzo = "+resultado.getInt(5));
                System.out.println("Abril = "+resultado.getInt(6));
                System.out.println("Mayo = "+resultado.getInt(7));
                System.out.println("Junio = "+resultado.getInt(8)); 
            }
        } catch (SQLException ex) {
            System.out.println("Hubo problem = "+ex.getMessage());
            
        }
}

  public static void ej5(int id){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/db_vendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","40%lkd2E");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "delete from db_vendedores.tb_vendedores where niv = "+id;
            // paso 5 ejecutamos el query
            sentencia.execute(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
        } catch (SQLException ex) {
            System.out.println("Hubo problem = "+ex.getMessage());
            
        }
}
 public static void ej4(String nombre, int id){
    //paso 1 creamos la conexion a la base de datos
        String url = "jdbc:mysql://localhost:3306/db_vendedores?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","40%lkd2E");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "update db_vendedores.tb_vendedores set Nombre = '"+nombre+"' where niv = "+id;
            // paso 5 ejecutamos el query
            sentencia.execute(sql);
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
        } catch (SQLException ex) {
            System.out.println("Hubo problem = "+ex.getMessage());
            
        }
}
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        int x, op;
        x = op = 0;
        while(op != 5){
            System.out.println("\n****MENU****");
            System.out.println("1. Consulta por NIV");
            System.out.println("2. Lista de Vendedores");
            System.out.println("3. Eliminar por NIV");
            System.out.println("4. Actualizar");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion.");
            op = t.nextInt();
            switch(op){
                case 1: 
                    System.out.println("Ingrese el niv del empleado que desee ver: ");
                    x = t.nextInt();
                    ej1(x);
                    break;
                case 2: 
                    ej2();
                    break;
                case 3:
                    int f = 0;
                    System.out.println("Ingrese el NIV del empleado que desee eliminar: ");
                    x = t.nextInt();
                    System.out.println("¿Está seguro de eliminar al empleado? 0=Si, 1=No, 2=Cancelar");
                    f = t.nextInt();
                    if(f == 0){
                        ej5(x);
                        System.out.println("Empleado eliminado.");
                    }
                    if(f == 1){
                        System.out.println("Okey, no se borro ningun registro");
                    }
                    if (f==2){
                        System.out.println("Se cancelo la eliminacion del empleado.");
                    }
                    break;
                case 4:
                    String name = "";
                    System.out.println("Ingrese el NIV del vendedor que desee actualizar: ");
                    x = t.nextInt();
                    System.out.println("Escriba el nuevo nombre a colocarle al empleado: ");
                    name = t.next();
                    ej4(name,x);
                    System.out.println("Se actualizo el empleado.");
                    break;
                case 5: 
                    System.out.println("¡Hasta luegooo!");
                    break;
                default:
                    System.out.println("La opcion escogida no es valida.");
            }
        }
        
    }
  
}
