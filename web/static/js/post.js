class Post{

	async get(url) {
        const respuesta = await fetch(url, { 
            method: 'GET',
             headers: {
                'Content-type': 'application/json'
            }
           });
        let posts = JSON.parse(await respuesta.text());
        return posts;
    }
	
	async insertar(url, data) {
        const respuesta = await fetch(url, {
            method: 'POST',
            headers: {
                'Content-type': 'application/json'
            },
            body: JSON.stringify(data)
        });
        return respuesta;
    }

}