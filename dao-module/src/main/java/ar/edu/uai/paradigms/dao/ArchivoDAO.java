package ar.edu.uai.paradigms.dao;

import ar.edu.uai.model.archivo.Archivo;
import ar.edu.uai.model.archivo.ArchivoCriteria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Facu on 3/12/2016.
 */
public class ArchivoDAO implements PersistentDAO<Archivo, Integer, ArchivoCriteria>{

    @PersistenceContext(unitName = "paradigms-persist-unit")
    private EntityManager entityManager;

    @Override
    public  Archivo create(Archivo archivo){
        this.entityManager.persist(archivo);
        return archivo;
    }

    @Override
    public Archivo retrieve(Integer id) {
        Archivo archivo = this.entityManager.find(Archivo.class, id);
        return archivo;
    }

    @Override
    public Archivo update(Archivo archivo) {
        return this.entityManager.merge(archivo);
    }

    @Override
    public void delete(Integer id) {
        this.entityManager.remove(this.retrieve(id));
    }

    @Override
    public List<Archivo> retrieveByCriteria(ArchivoCriteria archivoCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Archivo> query = cb.createQuery(Archivo.class);
        Root<Archivo> archivoRoot = query.from(Archivo.class);
        query.select(archivoRoot);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if(archivoCriteria.getNombre() != null) {
            predicates.add(cb.and(cb.like(archivoRoot.<String>get("nombre"), "%" + archivoCriteria.getNombre() + "%")));
        }

        if(archivoCriteria.getPath() != null) {
            predicates.add(cb.and(cb.like(archivoRoot.<String>get("path"), "%" + archivoCriteria.getPath() + "%")));
        }

        if(!predicates.isEmpty()) {
            query.where(predicates.toArray(new Predicate[predicates.size()]));
        }

        TypedQuery<Archivo> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }

    public List<Archivo> retrieveAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Archivo> query =cb.createQuery(Archivo.class);
        Root<Archivo> archivoRoot = query.from(Archivo.class);
        query.select(archivoRoot);

        TypedQuery<Archivo> typedQuery = entityManager.createQuery(query);

        return typedQuery.getResultList();
    }
}
