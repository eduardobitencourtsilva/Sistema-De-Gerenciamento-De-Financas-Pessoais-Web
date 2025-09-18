$(document).ready(function () {
    function listar(data) {
        $("#tabelaDespesas tbody").empty();
        for (let i = 0; i < data.length; i++) {
               let despesa = data[i];

               let id = $("<td>").text(despesa.id);
               let valor = $("<td>").text("R$ " + despesa.valor.toFixed(2).replace(".", ","));
               let nome = $("<td>").text(despesa.nome);
               let tipo = $("<td>").text(despesa.tipo);
               let categoria = $("<td>").text(despesa.categoria);
               let status = $("<td>").text(despesa.status);

               let tr = $("<tr>")
                       .attr("data-id", despesa.id)
                       .append(id, nome, valor, tipo, categoria, status);
               $("#tabelaDespesas tbody").append(tr);
        }
    }
    
    function tabelaListarDespesas() {
        $.ajax({
           url: "http://localhost:8080/despesas/listar",
           method: "GET",
           success: function (data) {
               listar(data);
           },
           error: function () {
               alert("Não foi possível carregar a tabela de despesas.");
           }
        });
    }
    
    function tabelaFiltrarDespesas(categoria) {
        $.ajax({
            url: "http://localhost:8080/despesas/pesquisarPorCategoria/" + categoria,
            method: "GET",
            success: function (data) {
                listar(data);
            },
            error: function () {
               alert("Não foi possível carregar a tabela de despesas.");
            }
        });
    }
    
    $("#cadastrar").click(function () {
        window.location.href = "cadastro";
    });
    
    $("#configurar").click(function () {
        window.location.href = "config";
    });
    
    $("#deslogar").click(function () {
        setCookie("loginID", 0, 1);
        alert("Saiu da conta com sucesso!");
        window.location.href = "/";
    });
    
    $("#filtro").change(function () {
        let categoria = $("#filtro").val();
        
        if (categoria)
            tabelaFiltrarDespesas(categoria);
        else
            tabelaListarDespesas();
    });
    
    tabelaListarDespesas();
});