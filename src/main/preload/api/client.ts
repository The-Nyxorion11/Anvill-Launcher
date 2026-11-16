async function nun (){

    const res = await fetch("http://localhost:7070/api/suma", {
        method: "POST", // o GET, según tu servidor
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ n1: 2, n2: 3 }),
    });

    console.log(res.status);
    console.log(await res.text());

}
nun();