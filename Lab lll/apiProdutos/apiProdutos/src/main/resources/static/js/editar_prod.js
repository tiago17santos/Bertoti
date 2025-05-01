document.addEventListener('DOMContentLoaded', async function () {
    const id = window.location.pathname.split("/").pop();

    try {
        const response = await fetch(`http://localhost:8080/produtos/${id}`);
        if (!response.ok) {
            throw new Error("Erro ao buscar produto.");
        }

        const produto = await response.json();

        // Preenche os campos
        document.getElementById('nomeProduto').value = produto.nome;
        document.getElementById('descricaoProduto').value = produto.descricao;
        document.getElementById('valorProduto').value = produto.preco;

        // Seleciona radio button de disponibilidade
        if (produto.disponivel) {
            document.getElementById('sim').checked = true;
        } else {
            document.getElementById('nao').checked = true;
        }

        // Preenche o select da categoria (você pode carregar as categorias dinamicamente também)
        const select = document.getElementById('catProd');
        const categorias = await fetch('http://localhost:8080/categorias');
        const lista = await categorias.json();

        lista.forEach(cat => {
            const option = document.createElement('option');
            option.value = cat.id;
            option.text = cat.nomeCat;
            if (cat.id === produto.categoriaId) {
                option.selected = true;
            }
            select.appendChild(option);
        });

    } catch (error) {
        console.error("Erro ao carregar produto:", error);
        document.getElementById('errorMessage').style.display = 'block';
        document.getElementById('errorText').textContent = 'Erro ao carregar dados. Tente novamente.';
    }
});
