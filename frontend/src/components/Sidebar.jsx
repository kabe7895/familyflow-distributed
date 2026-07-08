function Sidebar({ setPage }) {
    return (
        <aside className="sidebar">
            <h2>FamilyFlow</h2>

            <nav>
                <button onClick={() => setPage("dashboard")}>
                    Dashboard
                </button>

                <button onClick={() => setPage("tasks")}>
                    Tasks
                </button>

                <button onClick={() => setPage("family")}>
                    Family
                </button>
            </nav>
        </aside>
    );
}

export default Sidebar;