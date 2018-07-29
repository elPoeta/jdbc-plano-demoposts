let displayPosts = new DisplayPost();
const crearPost = document.querySelector('#crear-post');
let verPost = document.querySelector('#nav-post');
const traerPosts = new Post();
const URL_CATEGORIAS = 'api/categoriaServer';

const traerCategorias = new Categoria();
let categorias = [];



crearPost.addEventListener('click', (e) =>{
    let crearPost = new CrearPost();
     crearPost.mostrarCrearPost();
 });

verPost.addEventListener('click', ()=>{
	 buscarPost();
});

const iniciar = () =>{
	traerCategorias.get(URL_CATEGORIAS)
	.then(data => {
		 data.map(c => {
	         return   categorias.push(c);
	     });
	     });
	buscarPost();
}
function buscarPost(){
	 traerPosts.get('api/postServer?&q=0')
     .then(data => {
    	 displayPosts.mostrarTodos(data);
     });  
} 
window.addEventListener("load",iniciar,false); 
