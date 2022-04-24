package Cursada2022.TP1.EJ3;


public class Profesor{
    String nombre, apellido, email, catedra, facultad;

    public Profesor(){
        super();
    }

    public Profesor(String nombre, String apellido, String email, String catedra, String facultad){
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.setCatedra(catedra);
        this.setFacultad(facultad);
    }

    private String getNombre(){
        return this.nombre;
    }

    private String getApellido(){
        return this.apellido;
    }

    private String getEmail(){
        return this.email;
    }

    private String getCatedra(){
        return this.catedra;
    }

    private String getFacultad(){
        return this.facultad;
    }

    private void setNombre(String nombre){
        this.nombre = nombre;
    }

    private void setApellido(String apellido){
        this.apellido = apellido;
    }

    private void setEmail(String email){
        this.email = email;
    }

    private void setCatedra(String catedra){
        this.catedra = catedra;
    }

    private void setFacultad(String facultad){
        this.facultad = facultad;
    }

    public String tusDatos(){
        return "Nombre: " + this.getNombre() + "\nApellido: " + this.getApellido() + "\nEmail: " + this.getEmail() + "\nCatedra: " + this.getCatedra() + "\nFacultad: " + this.getFacultad();
    }
}