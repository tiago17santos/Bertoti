const disp = document.getElementById('disp');
const cat_prod = document.getElementById('cat_prod');
const drop_disp = document.getElementById('drop_disp');
const drop_cat = document.getElementById('drop_cat');
const opcao = document.querySelector('input[name="opcao"]:checked');

window.onload = function() {
    carregarProdutos();
    carregarCategorias();
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

function carregarCategorias() {
    fetch('/categorias')
        .then(response => response.json())
        .then(data => {
            const dropCat = document.getElementById('drop_cat');
            dropCat.innerHTML = '<option value="">Selecione</option>'; // limpa e adiciona o primeiro

            data.forEach(categoria => {
                const option = document.createElement('option');
                option.value = categoria.id;
                option.text = categoria.nomeCat;
                dropCat.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Erro ao carregar categorias:', error);
        });
}




// Botão de filtrar
document.getElementById('btn-filtrar').addEventListener('click', function() {
    carregarProdutos();
    carregarCategorias();
});

