import ClientService from "./ClientService.js";

const params = new URLSearchParams(window.location.search);
const clientId = params.get("id");

const cancelLink = document.getElementById("cancelLink");
cancelLink.href = `show.html?id=${clientId}`;

document
  .getElementById("clientForm")
  .addEventListener("submit", (event) => submitClient(event));

ClientService.findClientById(clientId).then((data) => renderClient(data));

function renderClient(data) {
  const name = document.getElementById("name");
  const cpf = document.getElementById("cpf");
  const birthDate = document.getElementById("birthDate");
  const address = document.getElementById("address");
  const contactsList = document.getElementById("contactList");

  name.value = data.nome;
  cpf.value = data.cpf;
  birthDate.value = data.dataNascimento;
  address.value = data.endereco;
}

async function submitClient(event) {
  event.preventDefault();
  const name = document.getElementById("name").value;
  const cpf = document.getElementById("cpf").value;
  const birthDate = document.getElementById("birthDate").value;
  const address = document.getElementById("address").value;

  const clientData = {
    nome: name,
    cpf: cpf,
    dataNascimento: birthDate,
    endereco: address,
  };

  const response = await ClientService.editClient(clientId, clientData);

  if (response) {
    const errorList = document.getElementById("errorList");
    response.forEach((message) => {
      let li = document.createElement("li");
      li.innerText = message;
      errorList.appendChild(li);
    });
  }
}
