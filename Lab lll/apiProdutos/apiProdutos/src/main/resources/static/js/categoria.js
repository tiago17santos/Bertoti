// Função para enviar o formulário de categoria
async function handleSubmit(event) {
    event.preventDefault(); // Previne o envio normal do formulário

    const formData = new FormData(document.getElementById('categoryForm'));

    const categoryData = {
        nomeCat: formData.get('nome')
    };

    try {
        // Envia os dados via POST para a API do Spring Boot
        const response = await fetch('/categorias', { // A URL da sua API para criar uma categoria
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(categoryData)
        });
        console.log(JSON.stringify(categoryData))
        if (!response.ok) {
            throw new Error('Erro ao cadastrar categoria');
        }

        alert('Categoria cadastrada com sucesso!');
        window.location.href = '/categoria'; // Redireciona para a lista de categorias
    } catch (error) {
        console.error('Erro:', error);
        document.getElementById('errorMessage').style.display = 'block';
        document.getElementById('errorText').textContent = 'Erro ao cadastrar categoria. Tente novamente.';
    }
}

// Adiciona o evento ao formulário de categoria
window.onload = function () {
    document.getElementById('categoryForm').addEventListener('submit', handleSubmit);
};
