package br.com.fiap.pedidoservice.controller;


import br.com.fiap.pedidoservice.model.Pedido;
import br.com.fiap.pedidoservice.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping
public class PedidoController {

    private final PedidoService pedidoService;
    @Autowired
    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = pedidoService.criarPedido(pedido);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(novoPedido);
        }
    }

    @GetMapping
    List<Pedido> listaPedidos() {
        return pedidoService.listarPedidos();
    }
}
