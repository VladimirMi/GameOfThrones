package ru.mikhalev.vladimir.gotfamilies.ui.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.mikhalev.vladimir.gotfamilies.R;
import ru.mikhalev.vladimir.gotfamilies.data.storage.Character;
import ru.mikhalev.vladimir.gotfamilies.utils.Helpers;

public class CharactersAdapter extends BaseAdapter{

    private List<Character> mCharacters;

    public CharactersAdapter(List<Character> characters) {
        mCharacters = characters;
    }

    @Override
    public int getCount() {
        return mCharacters.size();
    }

    @Override
    public Object getItem(int position) {
        return mCharacters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        LayoutInflater layoutInflater = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (itemView == null) {
            itemView = layoutInflater.inflate(R.layout.item_character_list, parent, false);
        }

        ImageView houseIcon = (ImageView) itemView.findViewById(R.id.house_icon_img);
        TextView characterNameView = (TextView) itemView.findViewById(R.id.character_name_txt);
        TextView characterDescView = (TextView) itemView.findViewById(R.id.character_desc_txt);


        String description = mCharacters.get(position).getTitles();
        if (description.isEmpty()) {
            description = mCharacters.get(position).getAliases();
        }
        if (description.isEmpty()) {
            description = "Missing description";
        }
        characterDescView.setText(description);
        characterNameView.setText((mCharacters.get(position).getName()));

        return itemView;
    }
}
