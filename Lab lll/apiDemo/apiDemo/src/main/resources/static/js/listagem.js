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
