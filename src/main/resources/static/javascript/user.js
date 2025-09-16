function getUser(id) {
   return new Promise((resolve, reject) => {
       $.ajax({
           url: "http://localhost:8080/login/listar",
           method: "GET",
           success: function (data) {
               let user = data.find(u => Number(u.id) === Number(id) || null);
               resolve(user);
           },
           error: function () {
              reject("Impossível acessar o banco de dados.");
           }
       });
   });
}