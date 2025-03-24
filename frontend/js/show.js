import ClientService from "./ClientService.js";
import ContatoService from "./ContatoService.js";

document.querySelector(".deleteLink").addEventListener("click", () => {
  handleDeleteClient();
});

const params = new URLSearchParams(window.location.search);
const clientId = params.get("id");

const editLink = document.getElementById("editLink");
editLink.href = `edit.html?id=${clientId}`;

const contactLink = document.getElementById("newContactLink");
contactLink.href = `contatos/new.html?id=${clientId}`;

ClientService.findClientById(clientId).then((data) => renderClient(data));

const contactsList = document.getElementById("contactList");
contactsList.addEventListener("click", (event) => {
  if (event.target.classList.contains("deleteLink")) {
    const contatoId = event.target.id;
    deleteContato(contatoId);
  }
});

function renderClient(data) {
  console.log(data);
  const name = document.getElementById("name");
  const cpf = document.getElementById("cpf");
  const birthDate = document.getElementById("birthDate");
  const address = document.getElementById("address");
  const contactsList = document.getElementById("contactList");

  name.innerText = data.nome;
  cpf.innerText = "cpf: " + data.cpf;
  birthDate.innerText = "data de nascimento: " + data.formattedBirthDate;
  address.innerText = "endereço: " + data.endereco;

  data.contatos.forEach((contato) => {
    let li = document.createElement("li");
    li.innerHTML = `<div>
            <div class="contatoDiv">
                <p>${contato.tipo} ${contato.valor}</p>
                <div>
                    <a href="contatos/edit.html?id=${clientId}&contatoId=${contato.id}">Editar</a>
                    <button class="deleteLink" id="${contato.id}">Excluir</button>
                </div>
            </div>
            <p>${contato.observacao}</p>
        </div>`;
    contactsList.appendChild(li);
  });
}

function handleDeleteClient() {
  const confirmDelete = confirm(`Tem certeza que deseja excluir esse cliente?`);
  if (!confirmDelete) return;

  ClientService.deleteClient(clientId);
}

function deleteContato(contatoId) {
  const confirmDelete = confirm(`Tem certeza que deseja excluir esse contato?`);
  if (!confirmDelete) return;

  ContatoService.deleteContact(clientId, contatoId).then(() => {
    document.getElementById(contatoId).closest("li").remove();
  });
}
