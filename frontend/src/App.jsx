import { BrowserRouter, Routes, Route, Link } from "react-router-dom";


function Dashboard() {
  return (
    <div>
      <h1>FamilyFlow Dashboard</h1>
      <h2>Welcome back!</h2>

      <div>
        <h3>Family</h3>
        <p>Miller Family</p>
      </div>

      <div>
        <h3>Tasks</h3>
        <p>3 open tasks</p>
      </div>
    </div>
  );
}


function Tasks() {
  return (
    <div>
      <h1>Tasks</h1>

      <ul>
        <li>☐ Buy groceries</li>
        <li>☑ Clean kitchen</li>
        <li>☐ Prepare dinner</li>
      </ul>

      <button>
        Add Task
      </button>

    </div>
  );
}


function Families() {
  return (
    <div>
      <h1>Family Members</h1>

      <ul>
        <li>Anna</li>
        <li>Tom</li>
        <li>Lisa</li>
      </ul>

      <button>
        Invite Member
      </button>

    </div>
  );
}



function App() {

  return (
    <BrowserRouter>

      <nav>
        <Link to="/">Dashboard</Link> |
        <Link to="/tasks"> Tasks</Link> |
        <Link to="/families"> Families</Link>
      </nav>


      <Routes>

        <Route 
          path="/" 
          element={<Dashboard />} 
        />

        <Route 
          path="/tasks" 
          element={<Tasks />} 
        />

        <Route 
          path="/families" 
          element={<Families />} 
        />

      </Routes>


    </BrowserRouter>
  );
}


export default App;