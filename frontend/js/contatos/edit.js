import ContatoService from "../ContatoService.js";

const params = new URLSearchParams(window.location.search);
const clientId = params.get("id");
const contatoId = params.get("contatoId");

const cancelLink = document.getElementById("cancelLink");
cancelLink.href = `../show.html?id=${clientId}`;

document
  .getElementById("contactForm")
  .addEventListener("submit", (event) => submitContact(event));

async function submitContact(event) {
  event.preventDefault();
  const type = document.getElementById("type").value;
  const value = document.getElementById("value").value;
  const observation = document.getElementById("observation").value;

  const contactData = {
    tipo: type,
    valor: value,
    observacao: observation,
  };

  const response = await ContatoService.updateContato(
    clientId,
    contatoId,
    contactData
  );

  if (response) {
    const errorList = document.getElementById("errorList");
    response.forEach((message) => {
      let li = document.createElement("li");
      li.innerText = message;
      errorList.appendChild(li);
    });
  }
}

ContatoService.findContatoById(contatoId).then((data) => {
  renderClient(data);
});

function renderClient(data) {
  const type = document.getElementById("type");
  const value = document.getElementById("value");
  const observation = document.getElementById("observation");

  console.log(data.tipo);
  type.value = data.tipo;
  value.value = data.valor;
  observation.value = data.observacao;
}
