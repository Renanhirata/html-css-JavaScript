document.getElementById('conversor').addEventListener('submit', async function(e) {
    e.preventDefault();

    const valor = parseFloat(document.getElementById('valor').value);
    const de = document.getElementById('de').value;
    const para = document.getElementById('para').value;

    document.getElementById('resultado').textContent = "";
    document.getElementById('erro').textContent = "";

    if (isNaN(valor)) {
        document.getElementById('erro').textContent = "Insira um valor numérico válido.";
        return;
    }

    try {
        const response = await fetch('http://localhost:8080/converter', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: new URLSearchParams({
                valor: valor.toString(),
                de: de,
                para: para
            })
        });

        if (!response.ok) throw new Error('Erro na requisição');

        const data = await response.json();

        if (data.erro) {
            document.getElementById('erro').textContent = data.erro;
        } else {
            document.getElementById('resultado').textContent = 
                `Resultado: ${data.resultado} ${data.unidade}`;
        }

    } catch (err) {
        document.getElementById('erro').textContent = "Erro: " + err.message;
    }
});
