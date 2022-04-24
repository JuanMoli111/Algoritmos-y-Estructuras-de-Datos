package Cursada2022.TP1.EJ3;


public class Test {
    public static void main(String[] args) {
        Estudiante[] arregloEstudiantes = new Estudiante[2];
        Profesor[] arregloProfesores = new Profesor[3];

        for (int i = 0; i < arregloProfesores.length; i++) {
            Profesor profesor = new Profesor("Pepe", "Perez", "Pepe@hotmail.com", "catedra de programacion", "facultad de ingenieria");
            arregloProfesores[i] = profesor;
            System.out.println(arregloProfesores[i].tusDatos());
        }

        for (int i = 0; i < arregloEstudiantes.length; i++) {
            Estudiante estudiante = new Estudiante("Juan", "Perez", "4B", "Juan@hotmail.com", "10 e/ 54 y 55");
            arregloEstudiantes[i] = estudiante;
            System.out.println(arregloEstudiantes[i].tusDatos());
        }



    }

    
}
