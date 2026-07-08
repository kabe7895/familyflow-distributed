import { useEffect, useState } from "react";
import { getFamilies, createFamily } from "../api/familyApi";


function FamilyManagement() {


    const [families, setFamilies] = useState([]);
    const [name, setName] = useState("");



    function loadFamilies() {

        getFamilies()
            .then(data => setFamilies(data))
            .catch(error => console.error(error));

    }



    useEffect(() => {

        loadFamilies();

    }, []);



    async function handleCreate() {

        if (!name.trim()) {
            return;
        }


        await createFamily(name);

        setName("");

        loadFamilies();

    }



    return (

        <div>

            <h2>Family Management</h2>


            <div className="card">

                <input
                    value={name}
                    onChange={e => setName(e.target.value)}
                    placeholder="Family name"
                />


                <button onClick={handleCreate}>
                    Create Family
                </button>


            </div>



            <div className="card">

                {
                    families.length === 0

                    ?

                    <p>No families found</p>

                    :

                    families.map(family => (

                        <p key={family.id}>
                            👨 {family.familyName}
                        </p>

                    ))

                }

            </div>


        </div>

    );
}


export default FamilyManagement;