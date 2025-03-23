import ClientService from "./ClientService.js";

document
  .getElementById("clientForm")
  .addEventListener("submit", (event) => submitClient(event));

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

  const response = await ClientService.saveClient(clientData);

  if (response) {
    const errorList = document.getElementById("errorList");
    response.forEach((message) => {
      let li = document.createElement("li");
      li.innerText = message;
      errorList.appendChild(li);
    });
  }
}
