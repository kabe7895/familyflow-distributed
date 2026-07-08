const API_URL = "http://localhost:8080/families";


export async function getFamilies() {

    const response = await fetch(API_URL);

    if (!response.ok) {
        throw new Error("Could not load families");
    }

    return await response.json();
}



export async function createFamily(familyName) {

    const response = await fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            familyName: familyName
        })
    });


    if (!response.ok) {
        throw new Error("Could not create family");
    }


    return await response.json();
}