// Função para tratar o envio do formulário via JavaScript (opcional)
document.getElementById('editProductForm').addEventListener('submit', async function (event) {
    event.preventDefault(); // Impede o envio tradicional

    const formData = new FormData(this);
    const productData = {
        nomeProd: formData.get('nomeProd'),
        descProd: formData.get('descProd'),
        valorProd: formData.get('valorProd'),
        disp: formData.get('disp'),
        catProd: formData.get('catProd')
    };

    try {
        const response = await fetch('/api/produtos/{{produto.id}}', {
            method: 'PUT', // Usando PUT para atualização
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(productData)
        });

        if (response.ok) {
            alert('Produto atualizado com sucesso!');
            window.location.href = '/produtos'; // Redireciona para a lista de produtos
        } else {
            throw new Error('Erro ao atualizar produto');
        }
    } catch (error) {
        document.getElementById('errorMessage').style.display = 'block';
        document.getElementById('errorText').textContent = 'Erro ao atualizar produto. Tente novamente.';
    }
});
