package com.formacionbdi.springboot.app.item.clientes;

import com.formacionbdi.springboot.app.item.models.Producto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {

    @GetMapping("/listar")
    public List<Producto> listar();


    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto);

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto update(@RequestBody Producto producto, @PathVariable Long id);

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id);
}
