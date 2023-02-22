import React, { Component } from 'react';
import { Outlet, Link } from 'react-router-dom';
import { Button, Container, Dropdown, Menu } from 'semantic-ui-react';
export default function Navi() {
    return (
        <div>
            <nav>
                <Menu inverted>
                    <Container>
                        <Link to="/haberler">
                            <Menu.Item
                                name='Haberler'
                            />
                        </Link>

                        <Link to="/duyurular">
                            <Menu.Item
                                name='Duyurular'
                            />
                        </Link>
                    </Container>
                </Menu>
            </nav>
            <Outlet/>
        </div>
    )
}
