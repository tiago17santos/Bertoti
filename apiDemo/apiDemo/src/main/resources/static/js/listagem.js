const disp = document.getElementById('disp');
const cat_prod = document.getElementById('cat_prod');
const drop_disp = document.getElementById('drop_disp');
const drop_cat = document.getElementById('drop_cat');

// Função para controlar o estado dos elementos de filtro
function verificaChecked() {
    if (disp.checked) {
        drop_disp.disabled = false;
        drop_cat.disabled = true;
    }

    if (cat_prod.checked) {
        drop_disp.disabled = true;
        drop_cat.disabled = false;
    }
}

verificaChecked();

// Adiciona ouvintes de evento para mudanças nos radios buttons
disp.addEventListener('change', verificaChecked);
cat_prod.addEventListener('change', verificaChecked);


fetch('/produtos?opcao=algumaOpcao&drop_disp=sim')
    .then(response => response.json())
    .then(data => {
        const produtosContainer = document.getElementById("produtos-lista");
        produtosContainer.innerHTML = ''; // Limpar a tabela antes de adicionar novos produtos
        data.forEach(produto => {
            const row = `<tr>
                <td>${produto.nome_prod}</td>
                <td>${produto.valor}</td>
                <td>${produto.disp == 1 ? 'Sim' : 'Não'}</td>
                <td>${produto.cat_prod.nome}</td>
                <td><a href="/listagem/editar/${produto.id}" class="btn btn-warning">Editar</a></td>
                <td><a href="/listagem/excluir/${produto.id}" class="btn btn-danger">Excluir</a></td>
            </tr>`;
            produtosContainer.innerHTML += row;
        });
    });
