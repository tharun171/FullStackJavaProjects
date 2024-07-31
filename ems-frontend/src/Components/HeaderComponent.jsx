import React from 'react'

const HeaderComponent = () => {
  return (
    <div>
        {/*ClassName and css will be from BootStrap */}
        <header>
            <nav className="navbar navbar-dark bg-dark">
                <a className="navbar-brand" href="/">Employee Management System</a>
            </nav>
        </header>
    </div>
  )
}

export default HeaderComponent