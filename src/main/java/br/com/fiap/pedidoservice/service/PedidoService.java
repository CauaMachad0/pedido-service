package br.com.fiap.pedidoservice.service;

import br.com.fiap.pedidoservice.dto.ProdutoDTO;
import br.com.fiap.pedidoservice.model.ItemPedido;
import br.com.fiap.pedidoservice.model.Pedido;
import br.com.fiap.pedidoservice.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private static final Logger logger = LoggerFactory.getLogger(PedidoService.class);
    private final PedidoRepository pedidoRepository;
    private final RestTemplate restTemplate;

    @Value("${catalogo.service.url}")
    private String catalogoServiceUrl;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, RestTemplate restTemplate){
        this.pedidoRepository = pedidoRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public Pedido criarPedido(Pedido pedido){
        logger.info("Criando pedido para o cliente {}", pedido.getIdCliente());
        double valorTotalCalculado = 0;

        for (ItemPedido itemPedido : pedido.getItens()) {
            // idProduto e qtd
            String urlProduto = catalogoServiceUrl + "/produtos/" + item.getIdProduto();
            logger.info("Consultando produto no catalogo-service {}", urlProduto);
            try {
                ProdutoDTO produto = restTemplate.getForObject(urlProduto, ProdutoDTO.class);
                if (produto == null){
                    logger.info("Produto {} encontrado: {}. Preço: {}" , produto.id(), produto.nome(), produto.preco());
                    valorTotalCalculado += produto.preco() * itemPedido.getQuantidade();
                } else {

                }
            } catch (HttpClientErrorException.NotFound e) {
                logger.warn("Porduto com id {} não encontrado no catalogo (404).", item.getIdProduto());
                throw new RuntimeException("Produto não encontrado no catalogo. ID: " + item.getIdProduto());
            } catch (Exception e) {
                logger.error("Erro ao consultar produto no catálogo: {}", e.getMessage());
                throw new RuntimeException("Erro ao consultar Produto" + e.getMessage());
            }
        }
    }
}
