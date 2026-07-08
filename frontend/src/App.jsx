import { useState } from "react";

import Sidebar from "./components/Sidebar";
import Header from "./components/Header";

import Dashboard from "./pages/Dashboard";
import Tasks from "./pages/Tasks";
import FamilyManagement from "./pages/FamilyManagement";


function App() {

    const [page, setPage] = useState("dashboard");


    function renderPage() {

        if (page === "tasks") {
            return <Tasks />;
        }

        if (page === "family") {
            return <FamilyManagement />;
        }

        return <Dashboard />;
    }


    return (
        <div className="app">

            <Sidebar setPage={setPage} />

            <main className="content">

                <Header />

                {renderPage()}

            </main>

        </div>
    );
}


export default App;