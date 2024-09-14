package ed.coder.after2.controller;

import ed.coder.after2.model.Venta;
import ed.coder.after2.model.VentaProducto;
import ed.coder.after2.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping("/crear/{clienteId}")
    public Venta RealizarVenta(
            @PathVariable Long clienteId,
            @RequestBody VentaProducto ventaProducto) {
        return ventaService.realizarVenta(clienteId,ventaProducto.getProducto().getId(), ventaProducto.getCantidad());
    }
}
