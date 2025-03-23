import ClientService from "./ClientService.js";

ClientService.getClientsFetch().then((data) => renderClientes(data));

document.getElementById("searchButton").addEventListener("click", () => {
  const nome = document.getElementById("nameInput").value;
  const cpf = document.getElementById("cpfInput").value;

  ClientService.getClientsFetch(nome, cpf).then((data) => renderClientes(data));
});

function renderClientes(clients) {
  const container = document.getElementById("clientList");
  container.innerHTML = "";
  clients.forEach((client) => {
    const link = document.createElement("a");
    link.href = `show.html?id=${client.id}`;
    const card = document.createElement("div");
    link.appendChild(card);
    card.className = "client-card";
    card.innerHTML = `
    <p> ${client.nome}</p>
    <p class="cpfText"> ${client.cpf}</p>
    `;
    container.appendChild(link);
  });
}
