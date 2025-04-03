// Função para carregar categorias
async function loadCategories() {
    try {
        const response = await fetch('http://localhost:8080/cadastro'); // A URL da sua API para categorias
        const categorias = await response.json();
        const selectElement = document.getElementById('catProd');
        categorias.forEach(categoria => {
            const option = document.createElement('option');
            option.value = categoria.id;
            option.textContent = categoria.nome;
            selectElement.appendChild(option);
        });
    } catch (error) {
        console.error('Erro ao carregar categorias:', error);
    }
}

// Função para enviar o formulário
async function handleSubmit(event) {
    event.preventDefault(); // Previne o envio normal do formulário
    const formData = new FormData(document.getElementById('productForm'));

    const productData = {
        nomeProd: formData.get('nomeProd'),
        descProd: formData.get('descProd'),
        valorProd: formData.get('valorProd'),
        disp: formData.get('disp'),
        catProd: formData.get('catProd')
    };

    try {
        const response = await fetch('/api/produtos', { // A URL da sua API para criar um produto
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(productData)
        });

        if (!response.ok) {
            throw new Error('Erro ao cadastrar produto');
        }

        alert('Produto cadastrado com sucesso!');
        window.location.href = '/produtos'; // Redireciona para a lista de produtos
    } catch (error) {
        console.error('Erro:', error);
        document.getElementById('errorMessage').style.display = 'block';
        document.getElementById('errorText').textContent = 'Erro ao cadastrar produto. Tente novamente.';
    }
}

// Carregar categorias ao carregar a página
window.onload = function () {
    loadCategories();
    document.getElementById('productForm').addEventListener('submit', handleSubmit);
};
