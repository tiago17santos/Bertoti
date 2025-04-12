// Função para carregar categorias
async function loadCategories() {

    try {
        const selectElement = document.getElementById('catProd');
        selectElement.innerHTML = '<option>Carregando...</option>';
        const response = await fetch('http://localhost:8080/categorias'); // A URL da sua API para categorias

        if (!response.ok) {
            throw new Error(`Erro ao carregar categorias: ${response.status}`);
        }


        const categorias = await response.json();

        selectElement.innerHTML = '';
        categorias.forEach(categoria => {
            const option = document.createElement('option');
            option.value = categoria.id;
            option.textContent = categoria.nomeCat;
            selectElement.appendChild(option);
        });
    } catch (error) {
        console.error('Erro ao carregar categorias:', error);
        document.getElementById('errorMessage').style.display = 'block';
        document.getElementById('errorText').textContent = 'Erro ao carregar categorias. Tente novamente.';
    }
}

// Função para enviar o formulário
async function handleSubmit(event) {
    event.preventDefault(); // Previne o envio normal do formulário
    const formData = new FormData(document.getElementById('productForm'));

    const productData = {
        nome: formData.get('nomeProd'),
        descricao: formData.get('descProd'),
        preco: formData.get('valorProd'),
        disponivel: formData.get('disp'),
        categoriaId: formData.get('catProd')
    };

    try {
        const response = await fetch('http://localhost:8080/produtos', { // A URL da sua API para criar um produto
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
        window.location.href = '/cadastro'; // Redireciona para a lista de produtos
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