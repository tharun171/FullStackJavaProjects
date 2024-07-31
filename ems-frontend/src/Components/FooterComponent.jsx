import React from 'react'
import '../CssFolder/FooterCss.css'; // Correct relative path to the CSS file


const FooterComponent = () => {
  return (
    <div className="footerDiv">
        <footer className="footer">
            <span className="text-center">All Rights Reserved 2024 by SpringBoot - Java</span>
        </footer>
    </div>
  )
}

export default FooterComponent