const disp = document.getElementById('disp');
const cat_prod = document.getElementById('cat_prod');
const drop_disp = document.getElementById('drop_disp');
const drop_cat = document.getElementById('drop_cat');
const opcao = document.querySelector('input[name="opcao"]:checked');

// Função para controlar o estado dos elementos de filtro
function verificaChecked() {
    if (disp.checked) {
        drop_disp.disabled = false;
        drop_cat.disabled = true;
    } else if (cat_prod.checked) {
        drop_disp.disabled = true;
        drop_cat.disabled = false;
    } else {
        drop_disp.disabled = true;
        drop_cat.disabled = true;
    }
}


// Adiciona ouvintes de evento para mudanças nos radios buttons
disp.addEventListener('change', verificaChecked);
cat_prod.addEventListener('change', verificaChecked);

window.onload = function() {
    carregarProdutos();
    verificaChecked();
}


// Função para carregar produtos filtrados
function carregarProdutos() {
    // Obtém os valores dos filtros
    const opcao = document.querySelector('input[name="opcao"]:checked');
    const opcaoValor = opcao ? opcao.value : '';
    const dropDispValor = drop_disp ? drop_disp.value : '';
    const dropCatValor = drop_cat ? drop_cat.value : '';

    const params = new URLSearchParams();

    if (opcaoValor) {
        params.append('opcao', opcaoValor);
    }
    if (dropDispValor && drop_disp.disabled === false) {
        params.append('drop_disp', dropDispValor);
    }
    if (dropCatValor && drop_cat.disabled === false) {
        params.append('drop_cat', dropCatValor);
    }

    const url = `/produtos/filtrar?${params.toString()}`;

    fetch(url)
        .then(response => response.json())
        .then(data => {
            const produtosContainer = document.getElementById("produtos-lista");
            produtosContainer.innerHTML = ''; // Limpar a tabela antes de adicionar novos produtos
            data.forEach(produto => {
                const row = `<tr>
                    <td>${produto.nome}</td>
                    <td>${produto.preco}</td>
                    <td>${produto.disponivel ? 'Sim' : 'Não'}</td>
                    <td>${produto.categoriaId}</td>
                    <td><a href="/editar_prod/${produto.id}" class="btn btn-warning">Editar</a></td>
                    <td><a href="/listagem/excluir/${produto.id}" class="btn btn-danger">Excluir</a></td>
                </tr>`;
                produtosContainer.innerHTML += row;
            });
        });
}



// Botão de filtrar
document.getElementById('btn-filtrar').addEventListener('click', function() {
    carregarProdutos();
});