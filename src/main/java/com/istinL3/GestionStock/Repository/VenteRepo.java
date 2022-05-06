package com.istinL3.GestionStock.Repository;
import com.istinL3.GestionStock.Model.Vente;
import com.istinL3.GestionStock.Model.custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VenteRepo extends JpaRepository<Vente, Integer> {
    @Query("select  distinct v from Vente v ")
    List<Vente> getall();

    @Query("select v from Vente v where v.numero = :x ")
    List<Vente>getleRecue(@Param("x") int numero);

    @Query("select distinct v.client.nom from Vente v where v.numero = :n ")
    public String getNom(@Param("n") int numero);

    @Query("select sum(v.article.prix * v.qtVendue )  from Vente v where v.numero = :n ")
    public String gettotale(@Param("n") int numero);
}
