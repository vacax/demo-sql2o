package com.avathartech.demosql2o;

import com.avathartech.demosql2o.dao.EstudianteDao;
import com.avathartech.demosql2o.encapsulacion.Estudiante;

import java.util.List;

/**
 * Demo de la funcionalida de la libreria Sql2o
 * Created by vacax on 07/04/17.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Prueba Dao");
        EstudianteDao estudianteDao = new EstudianteDao();
        List<Estudiante> allEstudiante = estudianteDao.getAllEstudiante();
        for(Estudiante estudiante : allEstudiante){
            System.out.printf("Matricula: %d - Nombre: %s\n",
                    estudiante.getMatricula(), estudiante.getNombre());
        }

    }
}
