import React, { useState, useEffect } from 'react'
import { Item, Popup } from 'semantic-ui-react'
import HaberService from '../services/haberService'

export default function HaberList() {
    const [haberler, setHeberler] = useState([]);
    useEffect(() => {
        let haberService = new HaberService();
        haberService.getNews().then(result => setHeberler(result.data.data))
    })
    return (
        <div className='haberler'>
            <Item.Group>
                {
                    haberler.map((haber) => (
                        <Popup trigger={
                            <Item>
                                <Item.Image size='tiny' src='https://react.semantic-ui.com/images/wireframe/image.png' />
                                <Item.Content verticalAlign='middle'>
                                    <Item.Header as='a'>{haber.konu}</Item.Header>
                                </Item.Content>
                            </Item>
                        }>
                            <Popup.Header>{haber.gecerlilikTarihi} tarihli haber</Popup.Header>
                            <Popup.Content>
                                <p>{haber.icerik}</p>
                            </Popup.Content>
                        </Popup>
                    ))
                }
            </Item.Group>
        </div>
    )
}
