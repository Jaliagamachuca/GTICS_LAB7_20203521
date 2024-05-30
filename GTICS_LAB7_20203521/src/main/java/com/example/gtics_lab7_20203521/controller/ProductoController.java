package com.example.gtics_lab7_20203521.controller;

import com.example.gtics_lab7_20203521.entity.Product;
import com.example.gtics_lab7_20203521.repository.ProductRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
public class ProductoController {

    final ProductRepository productRepository;

    public ProductoController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //LISTAR PLAYERS
    @GetMapping(value = {""})
    public List<Product> listaJugadores() {
        return productRepository.findAll();
    }

    //OBTENER PLAYERS POR REGIÓN
    @GetMapping(value = "/{region}")
    public List<Product> listaJugadoresRegion(@PathVariable("region") String region) {

        return productRepository.buscarPorRegion(region);
    }

    //BORRAR PLAYERS
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<HashMap<String, Object>> borrar(@PathVariable("id") String idStr){

        try{
            int id = Integer.parseInt(idStr);

            HashMap<String, Object> rpta = new HashMap<>();

            Optional<Product> byId = productRepository.findById(id);
            if(byId.isPresent()){
                productRepository.deleteById(id);
                rpta.put("result","ok");
            }else{
                rpta.put("result","no ok");
                rpta.put("msg","el ID enviado no existe");
            }

            return ResponseEntity.ok(rpta);
        }catch (NumberFormatException e){
            return ResponseEntity.badRequest().body(null);
        }
    }



}
