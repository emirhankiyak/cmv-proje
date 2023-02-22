import React, { useState, useEffect } from 'react'
import { Item, Popup } from 'semantic-ui-react'
import DuyuruService from '../services/duyuruService';

export default function HaberList() {
    const [duyurular, setDuyurular] = useState([]);
    useEffect(() => {
        let duyuruService = new DuyuruService();
        duyuruService.getNews().then(result => setDuyurular(result.data.data))
    })
    return (
        <div className='haberler'>
            <Item.Group>
                {
                    duyurular.map((duyuru) => (
                        <Item>
                            <Item.Image size='tiny' src='https://react.semantic-ui.com/images/wireframe/image.png' />
                            <Item.Content verticalAlign='middle'>
                                <Item.Header as='a'>{duyuru.konu}</Item.Header>
                                <Item.Content>{duyuru.icerik}</Item.Content>
                            </Item.Content>
                        </Item>
                    ))
                }
            </Item.Group>
        </div>
    )
}
