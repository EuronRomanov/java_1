package krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String cedula;
	private String nombre;
	private String apellido;
	private ArrayList<Nota> notas=new ArrayList();

	

	public Estudiante(String cedula, String nombre, String apellido) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void agregarNota(Nota nota) {
		// TODO Auto-generated method stub
		if (existeEnNotas(nota.getMateria().getCodigo())==-1 &&
				!estaRangoNota(nota.getCalificacion())) {
			
			notas.add(nota);
			
		}
		
	}

	public void modificarNota(String codigo, double nuevaNota) {
		// TODO Auto-generated method stub
		int i= existeEnNotas(codigo);
		if (i!=-1   ) {
			
			if (!estaRangoNota(nuevaNota)) {
				notas.get(i).setCalificacion(nuevaNota);
			}
			
		}else {
			System.out.println("No encontro el codigo");
		}
	}

	public double  calcularPromedioNotasEstudiante() {
		// TODO Auto-generated method stub
		
		double promedio=0;
		double total=0;
		for (Nota nota : notas) {
			total+=nota.getCalificacion();
		}
		promedio=total/notas.size();
		return promedio;
	}

	public void mostrar() {
		// TODO Auto-generated method stub
		String notasa="";
		for (Nota nota : notas) {
			notasa+=nota.toString()+"\n";
		}
		
		System.out.println("Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", notas \n" + notasa
				+ "]");
		
	}
	
	private int existeEnNotas(String codigo) {
		
		int id=-1;
		
		if (notas.size()>0) {
			
			for (int i = 0; i < notas.size(); i++) {
				if (notas.get(i).getMateria().getCodigo().equals(codigo)) {
					id=i;
				}
			}
		}
		
		
		
		
		
		return id;
		
	}
	
	
	private boolean estaRangoNota(double nota) {
		boolean flag=false;
		
		if (nota<0 || nota>10) {
			flag=true;
		}
		return flag;
	}

	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", notas=" + notas
				+ "]";
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}
	
	
	

}
