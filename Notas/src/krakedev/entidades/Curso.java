package krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	
	private ArrayList<Estudiante> estudiantes =new ArrayList();

	public void matricularEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		String mensaje=buscarEstudiantePorCedula( estudiante);
		if (mensaje==null) {
			estudiantes.add(estudiante);
		}else {
			System.out.println(mensaje);
		}
		
		
		
	}

	public ArrayList<Estudiante> getEstudiantes() {
		// TODO Auto-generated method stub
		return estudiantes;
	}

	public double calcularPromedioCurso() {
		// TODO Auto-generated method stub
		double total=0;
		
		for (Estudiante estudiante : estudiantes) {
			total+=estudiante.calcularPromedioNotasEstudiante();
		}
		
		return total/estudiantes.size();
	}

	public void mostrar() {
		for (Estudiante estudiante : estudiantes) {
			System.out.println(estudiante);
		}
		
	}
	
	private String  buscarEstudiantePorCedula(Estudiante estudiante) {
		String mensaje=null;
		
		if (estudiantes.size()>0) {
			for (Estudiante est : estudiantes) {
				if (est.getCedula().equals(estudiante.getCedula())&&
				est.getNombre().equalsIgnoreCase(estudiante.getNombre()) &&
				est.getApellido().equalsIgnoreCase(estudiante.getApellido())) {
					mensaje="Ya existe estudiante";
				}
			}
		}
		
		
		
		return mensaje;
		
	}

	

	
	
}
