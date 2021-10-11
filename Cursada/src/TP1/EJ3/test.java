package TP1.EJ3;

//import TP1.EJ3.Estudiante;
//import TP1.EJ3.Profesor;

public class test {

    
    public static void main(String[] args) {
        
        Estudiante[] vecEstudiantes = new Estudiante[2];
        Profesor[] vecProfesores = new Profesor[3];

        for (int i = 0; i < vecEstudiantes.length; i++) {
            vecEstudiantes[i] = new Estudiante("d","e","f","e","cto");
        }

        for (int i = 0; i < vecProfesores.length; i++) {
            vecProfesores[i] = new Profesor("d","e","f","e","cto");
        }

        vecEstudiantes[1].setApellido("apellido falso 123");
        vecEstudiantes[0].setEmail("mail");


        vecProfesores[1].setNombre("felipe");
        vecProfesores[2].setNombre("Rodolfo");
        vecProfesores[2].setApellido("Bertone");

        vecProfesores[2].setCatedra("Fundamentos de Organizacion de Datos");

        for (Profesor profesor : vecProfesores) {
            System.out.println(profesor.tusDatos());
        }

        for (Estudiante estudiante : vecEstudiantes) {
            System.out.println(estudiante.tusDatos());
        }

    }
}
