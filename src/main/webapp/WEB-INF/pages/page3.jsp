<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>

        <jsp:include page="./fragment/_style.jsp"/>

    </head>
    <body>
        <jsp:include page="./fragment/_header.jsp"/>
        <jsp:include page="./fragment/_menu.jsp"/>


        <main>

            <div id="parent">
            </div>

            <form action="/demo1/api/User" method="POST">
                <input type="text" name="nom">
                <input type="text" name="prenom">
                <input type="submit" value="envoyer">

            </form>



            <input type="button" value="Recup" id="get">
        </main>

        <div id="parent2">
        </div>

        <input type="button" value="RecupTache" id="get2">
        </main>



        <div>
            <select name="taches" id="taches">
                <option value="">--Choissez une taches--</option>
            </select>
        </div>

        <div>
            <select name="taches2" id="taches2">
                <option value="">--Choissez une taches--</option>
            </select>
        </div>



        <fieldset>
            <legend>detail de la tache</legend>
            <form>
                <div>
                    <input type="text" id="nom" name="nom" placeholder="nom"></input>
                </div>
                <div>
                    <input type="text" id="description" name="descritpion" placeholder="description"></input>
                </div>
            </form>
        </fieldset>


        <jsp:include page="./fragment/_footer.jsp"/>


        <script>


            document.querySelector('#get').addEventListener('click',()=>{
                fetch("/coursmaven/api/User")
                    .then((response) => response.json())
                    .then((data)=>{
                        let parent = document.getElementById('parent');
                        console.table(data);
                        for(element of data){
                            let p = document.createElement('p');
                            p.innerHTML = element.nom + "---" +element.prenom +"<br>";
                            parent.appendChild(p);
                        }
                    });
            });

            document.querySelector('#get2').addEventListener('click',()=>{
                fetch("/coursmaven/api/Tache/all")
                    .then((response) => response.json())
                    .then((data)=>{
                        let parent = document.getElementById('parent2');
                        console.table(data);
                        for(element of data){
                            let p = document.createElement('p');
                            p.innerHTML = element.nom + "---" +element.description + " "+ element.date.dayOfMonth +"/" +element.date.monthValue +"/" + element.date.year +"<br>";
                            parent.appendChild(p);
                        }
                    });
            });

            fetch("/coursmaven/api/Tache/all")
                .then((response) => response.json())
                .then((data)=>{
                    let parent = document.getElementById('taches');
                    let parent2 = document.getElementById('taches2');
                    console.table(data);
                    for(element of data){
                        let option = document.createElement('option');
                        option.data = element;
                        option.innerHTML = element.nom;
                        parent.appendChild(option);
                        let option2 = document.createElement('option');
                        option2.value = element.nom;
                        option2.innerHTML = element.nom
                        parent2.appendChild(option2)
                    }
                });


            let tachesSelect = document.querySelector('#taches');
            let tachesSelect2 = document.querySelector('#taches2');
            let inputNom = document.querySelector('#nom');
            let inputDescription = document.querySelector('#description');
            tachesSelect.addEventListener('change',()=>{
                inputDescription.value = tachesSelect.options[tachesSelect.selectedIndex].data.description;
                inputNom.value = tachesSelect.options[tachesSelect.selectedIndex].data.nom;
            });

            tachesSelect2.addEventListener('change',()=>{
                fetch("/coursmaven/api/Tache/byName/"+tachesSelect2.options[tachesSelect2.selectedIndex].value)
                    .then((response) => response.json())
                    .then((data)=>{
                        let toto;
                        inputDescription.value = data.description;
                        inputNom.value = data.nom;
                    });
            });

        </script>
    </body>
</html>